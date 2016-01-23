package com.mvc.controller;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student.do")
public class StudentController {
	//protected final transient Log log = LogFactory.getLog(StudentController.class);
	@Autowired
	private StudentService studentService;
	static List<Student> list;
	public StudentController(){
		
	}
	
	@RequestMapping
	public String load(HttpServletRequest request,ModelMap modelMap){
		
		try {
			//request.setAttribute("html", loadd(request));
			modelMap.put("html", loadd(request));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student";
	}
	
	public String loadd(HttpServletRequest pageContext) throws Exception
	{ 
		list = studentService.getStudentList();
		 Configuration cfg = new Configuration();        
        // 设置模板的路径
		System.out.println(pageContext.getServletPath());
		
        cfg.setServletContextForTemplateLoading(pageContext.getServletPath(),
        										"/templates");    
            
        //获取模板文件
        Template t = cfg.getTemplate("studentlist.ftl");        
        Writer out = new StringWriter(2048);   
        Map<String,Object>  root = new HashMap<String,Object> ();
        //放入对应数据key value
        root.put("mylist",list);
        t.process(root, out,ObjectWrapper.BEANS_WRAPPER);
        return out.toString();
        //t.process(root, new OutputStreamWriter(System.out),ObjectWrapper.BEANS_WRAPPER);
	}
	@RequestMapping(params = "method=add")
	public String add(HttpServletRequest request, ModelMap modelMap) throws Exception{
		return "student_add";
	}
	
	@RequestMapping(params = "method=save")
	public String save(HttpServletRequest request, ModelMap modelMap){
		String user = request.getParameter("user");
		String psw = request.getParameter("psw");
		Student st = new Student();
		st.setName(user);
		st.setPsw(psw);
		try{
			studentService.save(st);
			modelMap.put("addstate", "添加成功");
		}
		catch(Exception e){
			//log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}
		
		return "student_add";
	}
	
	@RequestMapping(params = "method=del")
	public void del(@RequestParam("id") String id, HttpServletResponse response){
		try{
			Student st = new Student();
			st.setId(Integer.valueOf(id));
			studentService.delete(st);
			response.getWriter().print("{\"del\":\"true\"}");
		}
		catch(Exception e){
			//log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
