package io.cj.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import io.cj.portfolio.jpa.model.Author;
import io.cj.portfolio.jpa.model.Book;
import io.cj.portfolio.jpa.model.Dept;
import io.cj.portfolio.jpa.model.Label;
import io.cj.portfolio.jpa.model.LabelPortfolio;
import io.cj.portfolio.jpa.model.LoginUser;
import io.cj.portfolio.jpa.model.Portfolio;
import io.cj.portfolio.jpa.service.AuthorRepository;
import io.cj.portfolio.jpa.service.BookRepository;
import io.cj.portfolio.jpa.service.DeptRepository;
import io.cj.portfolio.jpa.service.LabelPortfolioRepository;
import io.cj.portfolio.jpa.service.LabelRepository;
import io.cj.portfolio.jpa.service.LoginUserRepository;
import io.cj.portfolio.jpa.service.PortfolioRepository;

@Configuration
public class DatabasePopulator implements CommandLineRunner {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private DeptRepository deptRepository;

	@Autowired
	private LoginUserRepository loginUserRepository;

	@Autowired
	private LabelRepository labelRepository;

	@Autowired
	private PortfolioRepository portfolioRepository;

	@Autowired
	private LabelPortfolioRepository labelportfolioRepository;

	public void run(String... arg0) throws Exception {
		Author horbny = new Author();
		horbny.setId(1L);
		horbny.setName("Nick Horby");

		Author smith = new Author();
		smith.setId(2L);
		smith.setName("Wilbur Smith");

		authorRepository.save(horbny);
		authorRepository.save(smith);

		Book highFidelty = new Book();
		highFidelty.setId(1L);
		highFidelty.setTitle("High fidelty");
		highFidelty.setAuthor(horbny);

		Book aLongWayDown = new Book();
		aLongWayDown.setId(2L);
		aLongWayDown.setTitle("A long way down");
		aLongWayDown.setAuthor(horbny);

		Book desertGod = new Book();
		desertGod.setId(3L);
		desertGod.setTitle("Desert god");
		desertGod.setAuthor(smith);

		bookRepository.save(highFidelty);
		bookRepository.save(aLongWayDown);
		bookRepository.save(desertGod);

		Dept dept1 = new Dept();

		dept1.setId(1L);
		dept1.setName("Group1");

		Dept dept2 = new Dept();
		dept2.setId(2L);
		dept2.setName("Group2");

		deptRepository.save(dept1);
		deptRepository.save(dept2);

		LoginUser loginUser1 = new LoginUser();
		loginUser1.setId(1L);
		loginUser1.setLoginid("loginid1@gmail.com");
		loginUser1.setDept(dept1);
		loginUser1.setName("name1111111");
		loginUser1.setPassword("password");

		LoginUser loginUser2 = new LoginUser();
		loginUser2.setId(2L);
		loginUser2.setLoginid("loginid2@gmail.com");
		loginUser2.setDept(dept1);
		loginUser2.setName("name2222222222");
		loginUser2.setPassword("password");

		LoginUser loginUser3 = new LoginUser();
		loginUser3.setId(3L);
		loginUser3.setLoginid("loginid3@gmail.com");
		loginUser3.setDept(dept2);
		loginUser3.setName("name3333333333");
		loginUser3.setPassword("password");

		loginUserRepository.save(loginUser1);
		loginUserRepository.save(loginUser2);
		loginUserRepository.save(loginUser3);

		Label label1 = new Label();
		label1.setId(1L);
		label1.setName("Label parent");
//		label1.setLoginUserID(1L);

		Label label2 = new Label();
		label2.setId(2L);
		label2.setName("Label child 1");
		label2.setParent(label1);
		label2.setLoginUserID(1L);

		Label label3 = new Label();
		label3.setId(3L);
		label3.setName("Label child 2");
		label3.setParent(label1);
		label3.setLoginUserID(1L);

		Label label4 = new Label();
		label4.setId(4L);
		label4.setName("Label chil3");
		label4.setParent(label1);
		label4.setLoginUserID(1L);

		labelRepository.save(label1);
		labelRepository.save(label2);
		labelRepository.save(label3);
		labelRepository.save(label4);

		Portfolio portfolio1 = new Portfolio();
		portfolio1.setId(1L);
		portfolio1.setName("Portfolio name1");

		Portfolio portfolio2 = new Portfolio();
		portfolio2.setId(2L);
		portfolio2.setName("Portfolio name2");

		Portfolio portfolio3 = new Portfolio();
		portfolio3.setId(3L);
		portfolio3.setName("Portfolio name3");
		portfolioRepository.save(portfolio1);
		portfolioRepository.save(portfolio2);
		portfolioRepository.save(portfolio3);


		LabelPortfolio lablePortfolio1 = new LabelPortfolio();

		lablePortfolio1.setId(1L);
		lablePortfolio1.setLabelid(1L);
		lablePortfolio1.setPortfolio(portfolio2);
		lablePortfolio1.setLoginId(1L);
		lablePortfolio1.setLabelDisplay("labelDisplay/111111");

		LabelPortfolio lablePortfolio2 = new LabelPortfolio();
		lablePortfolio2.setId(2L);
		lablePortfolio2.setLabelid(1L);
		lablePortfolio2.setPortfolio(portfolio3);
		lablePortfolio2.setLoginId(1L);
		lablePortfolio2.setLabelDisplay("labelDisplay/111111");

		LabelPortfolio lablePortfolio3 = new LabelPortfolio();
		lablePortfolio3.setId(3L);
		lablePortfolio3.setLabelid(1L);
		lablePortfolio3.setPortfolio(portfolio1);
		lablePortfolio3.setLoginId(1L);
		lablePortfolio3.setLabelDisplay("labelDisplay/111111");

		LabelPortfolio lablePortfolio4 = new LabelPortfolio();
		lablePortfolio4.setId(4L);
		lablePortfolio4.setLabelid(2L);
		lablePortfolio4.setPortfolio(portfolio1);
		lablePortfolio4.setLoginId(1L);
		lablePortfolio4.setLabelDisplay("labelDisplay/111111");

		LabelPortfolio lablePortfolio5 = new LabelPortfolio();
		lablePortfolio5.setId(5L);
		lablePortfolio5.setLabelid(3L);
		lablePortfolio5.setPortfolio(portfolio1);
		lablePortfolio5.setLoginId(1L);
		lablePortfolio5.setLabelDisplay("labelDisplay/111111");

		LabelPortfolio lablePortfolio6 = new LabelPortfolio();
		lablePortfolio6.setId(6L);
		lablePortfolio6.setLabelid(4L);
		lablePortfolio6.setPortfolio(portfolio2);
		lablePortfolio6.setLoginId(1L);
		lablePortfolio6.setLabelDisplay("labelDisplay/111111");

		labelportfolioRepository.save(lablePortfolio1);
		labelportfolioRepository.save(lablePortfolio2);
		labelportfolioRepository.save(lablePortfolio3);
		labelportfolioRepository.save(lablePortfolio4);
		labelportfolioRepository.save(lablePortfolio5);
		labelportfolioRepository.save(lablePortfolio6);
	}

}