<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giải phương trình bậc 2 & Kiểm tra tam giác</title>
</head>
<body>
    <h2>Phần a: Giải phương trình bậc 2 (ax² + bx + c = 0)</h2>
    <form method="post">
        a: <input type="number" name="a" required /><br/>
        b: <input type="number" name="b" required /><br/>
        c: <input type="number" name="c" required /><br/>
        <input type="submit" value="Giải và Kiểm tra"/>
    </form>

<%
    String sa = request.getParameter("a");
    String sb = request.getParameter("b");
    String sc = request.getParameter("c");

    if (sa != null && sb != null && sc != null) {
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int c = Integer.parseInt(sc);

        // a. Giải phương trình bậc 2
        out.println("<h3>Kết quả phương trình bậc 2:</h3>");
        if (a == 0) {
            if (b == 0) {
                out.println(c == 0 ? "Phương trình vô số nghiệm." : "Phương trình vô nghiệm.");
            } else {
                double x = -1.0 * c / b;
                out.println("Phương trình có nghiệm duy nhất: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                out.println("Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2.0 * a);
                out.println("Phương trình có nghiệm kép: x = " + x);
            } else {
                out.println("Phương trình vô nghiệm thực.");
            }
        }

        // b. Kiểm tra có phải 3 cạnh tam giác không
        out.println("<h3>Kiểm tra tam giác:</h3>");
        if (a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a)) {
            out.println("Ba số là độ dài của một tam giác.");
        } else {
            out.println("Ba số KHÔNG phải là độ dài của một tam giác.");
        }
    }
%>
</body>
</html>
