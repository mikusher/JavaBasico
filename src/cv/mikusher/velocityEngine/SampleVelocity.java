




package cv.mikusher.velocityEngine;





import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;





public class SampleVelocity {

    public static void main(String[] args) throws Exception {

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        Template t = null;
        try {
            t = ve.getTemplate("src/cv/mikusher/velocityEngine/datapage.vm");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        VelocityContext vc = new VelocityContext();
        vc.put("username", "John");

        StringWriter sw = new StringWriter();
        t.merge(vc, sw);

        System.out.println(sw);

    }
}
