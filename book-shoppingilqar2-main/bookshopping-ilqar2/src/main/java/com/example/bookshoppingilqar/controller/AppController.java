package com.example.bookshoppingilqar.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookshoppingilqar.dao.BasketBooksDao;
import com.example.bookshoppingilqar.dao.BooksDao;
import com.example.bookshoppingilqar.dao.CustomerDao;
import com.example.bookshoppingilqar.dao.OrdersDao;
import com.example.bookshoppingilqar.entity.BasketBooks;
import com.example.bookshoppingilqar.entity.Books;
import com.example.bookshoppingilqar.entity.Customer;
import com.example.bookshoppingilqar.entity.Orders;
import com.example.bookshoppingilqar.entity.Users;
import com.example.bookshoppingilqar.service.BasketBooksService;
import com.example.bookshoppingilqar.service.BookService;


@Controller
@RequestMapping("/book-shopping")
public class AppController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	BookService bookService;
	
	BooksDao bookDao;
	BasketBooksService basketBookService;
	BasketBooksDao basketBooksDao;
	OrdersDao orderDao;
	CustomerDao customerDao;
	@Autowired
	public AppController(BookService theBookService,BasketBooksService theBasketBookService,BooksDao theBookDao) {
		bookService = theBookService;
		basketBookService = theBasketBookService;
		bookDao = theBookDao;
	}

	@RequestMapping("/customLogin")
    public String viewLoginPage() {
        return "login-page";
    }
	
	@RequestMapping("/books")
    public String viewErrorPage(Model model, HttpServletRequest request) {
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		List<Books> books= bookDao.getBooksByUsername(user.getUsername());
		model.addAttribute("books",books);
		model.addAttribute("theUser",user);
        return "myBooks";
    }
	@RequestMapping("/")
    public String viewDefaultPage() {
        return "default-page";
    }

	@RequestMapping("/homeRedirect")
    public String viewHomePage(Model model,HttpServletRequest request) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Users> query = session.createQuery("from Users s where s.username = '"+request.getParameter("username")+"'",Users.class);
		
			Users user = null;
			try {
				user = query.getSingleResult();
				if (user.getPassword().equals(request.getParameter("password"))) {
					model.addAttribute("theUser",user);
			        return "redirectToHome";
				}else {
		        return "redirectToCustomLogin";
		        }
			}catch(Exception e){
				return "redirectToCustomLogin";
			}
			
    }
	@RequestMapping("/home")
	public String viewHomePageBack(Model model,HttpServletRequest request) {
		Users user = new Users();
		user.setUsername(request.getParameterValues("username")[0]);
		model.addAttribute("theUser",user);
		return "home";
	}
	@RequestMapping("/home/customer")
	public String viewHomePageBackCustomer(Model model,HttpServletRequest request) {
		
		
		List<Books> books= bookService.findAll();
		model.addAttribute("books",books);
		List<BasketBooks> basketBooks= basketBookService.findAll();
		model.addAttribute("basketBooks",basketBooks);
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		model.addAttribute("theUser",user);
		return "customerHome";
	}
	
	@RequestMapping("/redirectToCus")
	public String regNewUser(Model model,HttpServletRequest request) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Users> query = session.createQuery("from Users s where s.username = '"+request.getParameter("username")+"'",Users.class);

		Users user =  null;
		try {
			 user = query.getSingleResult();
			 
						session.close();
						return "redirectToRegister";
					
		}catch(Exception e){
			user = new Users(request.getParameter("username"),request.getParameter("password"),1);
			session.beginTransaction();

			session.save(user);  

			session.getTransaction().commit();
			session.close();
			return "redirectToCustomLogin";
		}finally {
			session.close();
		}
		

	}
	@RequestMapping("/register")
	public String RegisterPage(Model model,HttpServletRequest request) {
			return "register";
	}
	@RequestMapping("/customer")
	public String viewBooksPage(Model model) {
		List<Books> books= bookService.findAll();
		model.addAttribute("books",books);
		List<BasketBooks> basketBooks= basketBookService.findAll();
		model.addAttribute("basketBooks",basketBooks);
		return "books";
	}
	@RequestMapping("/update")
	public String customerUpdate(Model model,HttpServletRequest request) {
		Books book = new Books();
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		book = bookDao.getBooksById(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("theUser",user);
		model.addAttribute("book",book);
		return "book-update";
	}
	
	@RequestMapping("/delete")
	public String customerDelete(HttpServletRequest request,Model model) {
		Session session = sessionFactory.getCurrentSession();
		Users user = new Users();
		Books book = new Books();
		Query<BasketBooks> query = session.createQuery("from BasketBooks order "+" WHERE order.bookId = '"+request.getParameter("id")+"'",BasketBooks.class);
		List<BasketBooks> listOfBasketBooks = query.getResultList();
		if(listOfBasketBooks != null) {
			for (int i = 0; i < listOfBasketBooks.size(); i++) {
				session.delete(listOfBasketBooks.get(i));
			}
		}
		user.setUsername(request.getParameter("username"));
		model.addAttribute("theUser",user);
		book = bookDao.getBooksById(Integer.parseInt(request.getParameter("id")));
		bookDao.deleteBook(book,Integer.parseInt(request.getParameter("id")));
		List<Books> books= bookDao.getBooksByUsername(user.getUsername()); 
		model.addAttribute("books",books);
		model.addAttribute("theUser",user);
		return "redirectToMyBooks";
	}
	
	@RequestMapping("/confirm-order")
	public String confirmOrder(HttpServletRequest request,Model model) {
		int countofbooks= Integer.parseInt(request.getParameter("countofbooks"));
		List<BasketBooks> bBook = new ArrayList<BasketBooks>();
		for (int i = 0; i < countofbooks; i++) {
			 BasketBooks bBookAdd = new BasketBooks(Integer.parseInt(request.getParameterValues("count")[i]),Integer.parseInt(request.getParameterValues("id")[i]));
			 bBook.add(bBookAdd);
		}
		model.addAttribute("basketBooks",bBook);
		return "orders";
	}
	@RequestMapping("/new-order")
	public String newOrder(HttpServletRequest request,Model model) {
		Session session = sessionFactory.getCurrentSession();
		int countofbooks= Integer.parseInt(request.getParameter("countofbooks"));
		double totalPrice = 0;
		java.util.Date date=java.util.Calendar.getInstance().getTime();
		Customer customer = new Customer(request.getParameter("name"),request.getParameter("address"),request.getParameter("email"),request.getParameter("note"),request.getParameter("phone"));
		for (int i = 0; i < countofbooks; i++) {
			BasketBooks bBookAdd = new BasketBooks(Integer.parseInt(request.getParameter("count"+(i+1))),Integer.parseInt(request.getParameter("id"+(i+1))));
			Query<Books> queryay = session.createQuery("from Books b "+" WHERE b.id = '"+Integer.parseInt(request.getParameter("id"+(i+1)))+"'",Books.class);
			List<Books> booksa= queryay.getResultList();
			totalPrice = Integer.parseInt(request.getParameter("count"+(i+1)))*booksa.get(0).getPrice();
			Books book = bookDao.getBooksById(Integer.parseInt(request.getParameter("id"+(i+1))));
			Orders order = new Orders(request.getParameter("note"),date,totalPrice,book.getUsername());
			order.setCustomer(customer);
			order.addBasketBook(bBookAdd);
			bBookAdd.setOrder(order);
			
			session.save(order);
			session.save(bBookAdd);
			
		}
		session.save(customer);
		return "submitOrder";
	}
	@RequestMapping("/my-orders")
	public String myOrders(HttpServletRequest request,Model model) {
		Session session =sessionFactory.getCurrentSession();
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		Query<Orders> query = session.createQuery("from Orders order "+" WHERE order.username = '"+user.getUsername()+"'",Orders.class);
		List<Orders> orders = query.getResultList();
		List<Books> books= new  ArrayList<Books>();
		List<Customer> customers= new  ArrayList<Customer>();
		List<BasketBooks> basketBook = new ArrayList<BasketBooks>();
		int ey = -1;
		int delta=0;
		for(int i = 0; i < orders.size();i++) {
			
			if(session.createQuery("from BasketBooks basketBook "+" WHERE basketBook.orderId = '"+orders.get(i).getId()+"'",BasketBooks.class) != null) {
				try {
					Query<BasketBooks> querya = session.createQuery("from BasketBooks basketBook "+" WHERE basketBook.orderId = '"+orders.get(i).getId()+"'",BasketBooks.class);
					BasketBooks basketBooks = querya.getSingleResult();
					Query<Books> queryay = session.createQuery("from Books b "+" WHERE b.id = '"+basketBooks.getBookId()+"'",Books.class);
					Books booksa= queryay.getSingleResult();
					Query<Customer> queryaya = session.createQuery("from Customer customer "+" WHERE customer.id = '"+orders.get(i).getCutomerId()+"'",Customer.class);
					Customer customer = queryaya.getSingleResult();
					basketBook.add(basketBooks);
					books.add(booksa);
					customers.add(customer); 
					
				}catch(Exception e) {
					orders.remove(orders.get(i));
					i--;
				}
				
			}
			
		}
		System.out.println(customers);
		System.out.println(books);
		System.out.println(basketBook);
		model.addAttribute("basketBooks", basketBook);
		model.addAttribute("books", books);
		model.addAttribute("customers", customers);
		model.addAttribute("orders",orders);
		model.addAttribute("theUser",user);
		return "myOrders";
	}
}
