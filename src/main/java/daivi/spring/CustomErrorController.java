package daivi.spring;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import daivi.Constants;

@Controller
public class CustomErrorController implements ErrorController {
  
    private static final String PATH = "/custom_error";
     
    @RequestMapping(value=PATH)
    public String error() {
        return Constants.ERROR_HTML_CPATH;
    }
 
    @Override
    public String getErrorPath() {
        return PATH;
    }
}