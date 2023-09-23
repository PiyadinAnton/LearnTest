package ui;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*public class TestRunner {
    public static void main(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("Test Suite");
        suite.setParallel(XmlSuite.ParallelMode.TESTS);

        XmlTest test1 = new XmlTest(suite);
        test1.setName("Test 1");
        test1.setXmlClasses(Arrays.asList(new XmlClass("ui.BuzzTest")));

        XmlTest test2 = new XmlTest(suite);
        test2.setName("Test 2");
        test2.setXmlClasses(Arrays.asList(new XmlClass("ui.DashboardTest")));

        XmlTest test3 = new XmlTest(suite);
        test3.setName("Test 3");
        test3.setXmlClasses(Arrays.asList(new XmlClass("ui.PimTest")));

        XmlTest test4 = new XmlTest(suite);
        test4.setName("Test 4");
        test4.setXmlClasses(Arrays.asList(new XmlClass("ui.LoginTest")));

        XmlTest test5 = new XmlTest(suite);
        test5.setName("Test 5");
        test5.setXmlClasses(Arrays.asList(new XmlClass("ui.RandomTest")));

        XmlTest test6 = new XmlTest(suite);
        test6.setName("Test 6");
        test6.setXmlClasses(Arrays.asList(new XmlClass("ui.ClaimTest")));


        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();
    }
}*/