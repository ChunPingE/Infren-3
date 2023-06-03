package hello.servlet.web.frontcontroller.v3;

import java.util.*;

import hello.servlet.web.frontcontroller.*;

public interface ControllerV3 {
	ModelView process(Map<String, String> paramMap);
}
