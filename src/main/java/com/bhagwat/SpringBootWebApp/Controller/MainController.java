package com.bhagwat.SpringBootWebApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bhagwat.SpringBootWebApp.Model.Author;
import com.bhagwat.SpringBootWebApp.Model.Book;
import com.bhagwat.SpringBootWebApp.Model.User;
import com.bhagwat.SpringBootWebApp.Services.AuthorService;
import com.bhagwat.SpringBootWebApp.Services.BookService;
import com.bhagwat.SpringBootWebApp.Services.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private AuthorService authorService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private HttpSession session;

	@PostMapping("/LoginModule")
	public String loginModule(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "login";
		}
		if (userService.isExistUser(user)) {
			session.setAttribute("username", user.getUsername());
			return "redirect:/mainModule";
		}
		result.rejectValue("username", "error.user", "This Username Does Not Exist");
		return "login";
	}

	@PostMapping("/SignUpModule")
	public String signUpModule(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "signup";
		}

		if (userService.isExistUser(user)) {
			result.rejectValue("username", "error.user", "This Username already exist");
			return "signup";
		}
		userService.saveUser(user);

		session.setAttribute("username", user.getUsername());
		return "redirect:/mainModule";
	}

	@PostMapping("/addBookModule")
	public String addBookModule(@RequestParam("bookCode") Long bookCode, @RequestParam("name") String name,
			@RequestParam("authorId") Long authorId, @RequestParam("date") String date) {

		Author author = authorService.getById(authorId);
		Book book = new Book(bookCode, author, name, date);

		if (bookService.isExist(bookCode)) {
			return "redirect:/addEditBookPage?error=This Bookcode aleady exist";
		}
		bookService.saveBook(book);
		return "redirect:/mainModule";
	}

	@PostMapping("/editBookModule")
	public String editBookModule(@RequestParam("bookCode") Long bookCode, @RequestParam("name") String name,
			@RequestParam("authorId") Long authorId) {

		Author author = authorService.getById(authorId);

		Book book = bookService.getBookById(bookCode);
		book.setName(name);
		book.setAuthor(author);

		bookService.saveBook(book);
		return "redirect:/mainModule";
	}

	@PostMapping("/addAuthor")
	public void addAuthor(@Valid Author author, BindingResult result) {
		authorService.saveAuthor(author);
		return;
	}

	@GetMapping("/mainModule")
	public ModelAndView mainModule() {

		ModelAndView modelAndView = new ModelAndView();

		List<Book> bookList = bookService.getAllBooks();

		modelAndView.setViewName("main");
		modelAndView.addObject("bookList", bookList);
		return modelAndView;

	}

	@GetMapping("/deleteBook")
	public String deleteBook(Long bookCode) {
		bookService.deleteBookById(bookCode);
		return "redirect:/mainModule";
	}

	@GetMapping("/addEditBookPage")
	public ModelAndView addBook(Long bookCode, String error) {
		ModelAndView modelAndView = new ModelAndView();

		if (bookCode != null) {
			Book book = bookService.getBookById(bookCode);
			modelAndView.addObject("book", book);
		}
		if (error != null) {
			modelAndView.addObject("error", error);
		}

		List<Author> authors = authorService.getAllAuthors();
		modelAndView.addObject("authorList", authors);

		modelAndView.setViewName("addBook");

		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView Logout() {
		session.removeAttribute("username");
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;

	}

}
