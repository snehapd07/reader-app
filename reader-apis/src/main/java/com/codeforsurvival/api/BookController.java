package com.codeforsurvival.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.codeforsurvival.util.FileUtils;

@Controller
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	@Autowired
	BookManager bookManager;
	@Autowired
	UserController userController;

	private static final String uploadPath = "/home/preetam/upload";

	@RequestMapping(value = { "/", "", "/all " }, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, List<Book>> getAllBooks() {
		Map<String, List<Book>> result = new HashMap<String, List<Book>>();
		result.put("books", bookManager.getAllBooks());
		return result;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Book getBookById(@PathVariable Long id) {
		Book book = bookManager.getBook(id);
		return book;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	List<Book> getBooksByUserId(@PathVariable Long userId) {
		return bookManager.getBooksByUserId(userId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Book addBook(HttpServletRequest request, @RequestBody Book book) {
		return bookManager.addBook(book);
	}

	@RequestMapping(value = "/{userId}/{status}", method = RequestMethod.GET)
	public @ResponseBody
	List<Book> getBooksByStatus(@PathVariable Long userId,
			@PathVariable String status) {
		return bookManager.getBooksByStatus(userId, status);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	Book handleFileUpload(HttpServletRequest request,
			@RequestParam("file") MultipartFile file, @RequestParam Long userId) {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String name = file.getOriginalFilename();
		String path = uploadPath + "/" + file.getOriginalFilename();
		Book newBook = null;
		if (!file.isEmpty() && null != userId) {
			try {
				byte[] bytes = file.getBytes();
				if (FileUtils.uploadFile(bytes, path)) {
					newBook = new Book(null, null, null, 0, 0, 0, name, userId);
					newBook = bookManager.addBook(newBook);
					return newBook;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return newBook;
	}

	@RequestMapping(value = "/download/{bookId}", method = RequestMethod.GET)
	public @ResponseBody
	void handleFileDownload(HttpServletRequest request,
			HttpServletResponse response, @PathVariable Long bookId) {
		// get absolute path of the application
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String appPath = uploadPath + "/";

		// get file link using book id
		Book book = this.bookManager.getBook(bookId);
		if (null == book) {
			return;
		}
		// construct the complete absolute path of the file
		String fullPath = appPath + book.getBookLink();
		File downloadFile = new File(fullPath);
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		// response.setHeader(headerKey, headerValue);
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] buffer = new byte[1024];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			inputStream.close();
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}