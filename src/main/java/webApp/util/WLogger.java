package webApp.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WLogger {

    static final Log log = LogFactory.getLog(Log.class);

    public static Log getLogger(){
        return log;
    }
}
