import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.view.InternalResourceView;
import webApp.data.Repository;
import webApp.data.TempRepositoryImpl;
import webApp.web.RegisterController;


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RegisterControllerTest {

    @Test
    public void testRegisterController() throws Exception{
        RegisterController controller = new RegisterController(new TempRepositoryImpl<>());
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/registration.jsp"))
                .build();
        mockMvc.perform(get("/registration"))
                .andExpect(view().name("registration"))
                .andExpect(model().attributeExists("human"));
    }
}
