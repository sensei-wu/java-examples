package basics;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExpensiveObject {

    static int counter = 0;

    private final NumberFormat FORMAT;

    private final ThreadMXBean THREAD_MX_BEAN;
    public boolean supports;

    public ExpensiveObject() {
        long t1 = System.currentTimeMillis();
        FORMAT = new DecimalFormat("###,###");
        long t2 = System.currentTimeMillis();

        System.out.println("DecimalFormat took " + (t2-t1) + " ms");

        t1 = System.currentTimeMillis();
        THREAD_MX_BEAN = ManagementFactory
                .getThreadMXBean();
        t2 = System.currentTimeMillis();

        //System.out.println("ManagementFactory getThreadMXBean() took " + (t2-t1) + " ms");

        t1 = System.currentTimeMillis();
        supports = THREAD_MX_BEAN.isCurrentThreadCpuTimeSupported();

        t2 = System.currentTimeMillis();

        //System.out.println("THREAD_MX_BEAN.isCurrentThreadCpuTimeSupported() " + (t2-t1) + " ms");
        //System.out.println(supports);

        counter++;
    }
}
