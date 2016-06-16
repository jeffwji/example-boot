<HTML>
<HEAD>
<TITLE>JSP测试页面---HelloWorld!</TITLE>
</HEAD>
<BODY>
	<div>
		<div>
			<a  href="/home"> <img src="/images/logo.png" /> </a>
			<ul>
				<li><a href="/home">Test HTML5 template</a></li>
				<li><a href="/logout">退出</a></li>
			</ul>
		</div>
	</div>

<%
	out.println("<h1>Hello World!<br>世界，你好！</h1>");
%>
</BODY>
</HTML>