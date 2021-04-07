import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
    public static void main(String[] args) throws Exception {

        //1. 加载驱动程序   使用Class.forName()显式加载驱动程序。
        String Driver = "oracle.jdbc.driver.OracleDriver";
        Class.forName(Driver);

        //2.建立连接
        String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
        String Username = "scott";
        String Password = "tiger";
        Connection connection = DriverManager.getConnection(URL, Username, Password);

        //3、测试连接是否成功
        System.out.println(connection);

        // 4、定义sql语句
        String sql = "select * from emp";

        //5、准备静态处理块对象
        Statement statement = connection.createStatement();

        //6、执行sql语句,返回结果集对象
        ResultSet resultSet = statement.executeQuery(sql);

        //7、循环处理
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
            String ename = resultSet.getString("ename");
            System.out.println(ename);
        }

        //8、关闭连接
        statement.close();
        connection.close();
        //over


    }

}
