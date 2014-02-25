package com.codeforsurvival.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codeforsurvival.db.entity.Book;
import com.codeforsurvival.manager.BookManager;

@Controller
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	@Autowired
	BookManager bookManager;

	@RequestMapping(value = { "/", "", "/all " }, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, List<Book>> getAllBooks() {
		Map<String, List<Book>> result = new HashMap<String, List<Book>>();
		result.put("books", bookManager.getAllBooks());
		return result;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Book addBook(@RequestBody Book book) {
		return bookManager.addBook(book);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Book getBookById(@PathVariable Long id) {
		return bookManager.getBook(id);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	String handleFileUpload(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String path = sc.getRealPath("/upload/") + "/";
		System.out.println(path);
		;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String name = file.getOriginalFilename();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + name + "9090")));
				stream.write(bytes);
				stream.close();
				return "You successfully uploaded " + name;
			} catch (Exception e) {
				e.printStackTrace();
				return "Upload Failed";
			}
		} else {
			return "Upload Failed";
		}
	}
}