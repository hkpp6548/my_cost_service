<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>使用队列来完成下载upload目录下所有文件</title>
</head>
<body>
	<!-- 使用队列操作 -->
	<%
		String path = request.getServletContext().getRealPath("/study/fileDownload/file");
		File uploadDirectory = new File(path);
		//创建一个队列
		Queue<File> queue = new LinkedList<File>();
		queue.offer(uploadDirectory);//放入队列
		while (!queue.isEmpty()) { //如果队列不为空
			File f = queue.poll(); //从队列中获取一个File
			if(f.isDirectory()){//是目录,将目录下所有文件遍历出来，存储到队列中
				File[] fs = f.listFiles();
				for (int i = 0; i < fs.length; i++) {
					queue.offer(fs[i]);
				}
			}else{
				String absolutePath=(f.getAbsolutePath());
				String p=absolutePath.substring(absolutePath.lastIndexOf("\\study"));
				System.out.println(p);
				out.println("<a href='" + p+"'>"+f.getName()+"</a><br>");
			}

		}
	%>


</body>
</html>
