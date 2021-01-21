import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyan.dao.IEmpMapper;
import com.xuyan.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package PACKAGE_NAME
 * @description
 * @date 2020/12/5 16:13
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class SSMInitTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;

    @Autowired
    private IEmpMapper empMapper;

    @Test
    public void testDataSource(){
        System.out.println(dataSource);
    }

    @Test
    public void testSqlSessionFactory(){
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void testEmpMapper(){

        Emp emp2 = new Emp();
        emp2.setId(25);

        for(int i = 0;i < 10;i++){
            Emp emp = new Emp();
            emp.setUsername("xu_" + i);
            emp.setPassword("pwd_" + i);
            emp.setBirthday(new Date());
            emp.setDeptno(10);
            emp.setEmail("admin_" + i + "@xu.com");
            emp.setSex((i & 1));
            emp.setCreateUser(emp2);//创建人
            emp.setMobile("1" + i + "385921" + i + "3" + i);
//        emp.setCreatTime(new Date());//这个属性插入会取当前时间
            emp.setUserpng("xxx_" + i + ".png");

            int x = empMapper.add(emp);

            System.out.println(x);
        }
    }

    @Test
    public void testupdate(){

        Emp emp2 = new Emp();
        emp2.setId(1);

        Emp emp = new Emp();
        emp.setId(43);
        emp.setUsername("yan");
        emp.setPassword("yan");
        emp.setBirthday(new Date());
        emp.setDeptno(20);
        emp.setEmail("xu@xu.com");
        emp.setSex(0);
        emp.setUpdateUser(emp2);//创建人
//        emp.setCreatTime(new Date());//这个属性插入会取当前时间
        emp.setUserpng("xu.png");

        int i = empMapper.update(emp);

        System.out.println(i);
    }

    @Test
    public void testdelete(){

        Emp emp2 = new Emp();
        emp2.setId(1);

        Emp emp = new Emp();
        emp.setId(43);

        int i = empMapper.deleteById(2);

        System.out.println(i);
    }

    @Test
    public void testGetEmpList(){

        PageHelper.startPage(1,10);
        List<Emp> empList = empMapper.getList();

        for(Emp e : empList){
            System.out.println(e);
        }

        PageInfo pageInfo = new PageInfo(empList);
        System.out.println(pageInfo.getList());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());
    }

    @Test
    public void testGetEmpById(){

            System.out.println(empMapper.selectById(25));

    }
}
