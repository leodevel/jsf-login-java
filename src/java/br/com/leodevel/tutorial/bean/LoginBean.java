package br.com.leodevel.tutorial.bean;

import br.com.leodevel.tutorial.controller.UserController;
import br.com.leodevel.tutorial.entity.User;
import br.com.leodevel.tutorial.session.SessionContext;
import br.com.leodevel.tutorial.util.Util;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String login = "";
    private String password = "";

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String signIn() {

        boolean errors = false;

        if (login.trim().isEmpty()) {
            FacesContext.getCurrentInstance()
                    .addMessage("formLogin:txtLogin",
                            new FacesMessage("Informe o login"));
            errors = true;
        }

        if (password.trim().isEmpty()) {
            FacesContext.getCurrentInstance()
                    .addMessage("formLogin:txtPassword",
                            new FacesMessage("Informe a senha"));
            errors = errors || true;
        }

        if (errors) {
            FacesContext.getCurrentInstance()
                    .addMessage("formLogin",
                            new FacesMessage("Erros de validação no formulário"));
            return "";
        }

        User user = UserController.getUserByLoginAndPassword(login, Util.convertStringToMd5(password));

        if (user == null) {
            FacesContext.getCurrentInstance()
                    .addMessage("formLogin",
                            new FacesMessage("Usuário não encontrado!"));
            return "";
        }

        SessionContext.getInstance().setUserLoggedIn(user);
        
        login = "";
        password = "";

        return "admin/home.xhtml?faces-redirect=true";
    }

    public String signOut(){
        SessionContext.getInstance().closeSession();
        return "/index.xhtml?faces-redirect=true";
    }
    
    public User getUserLoggedIn(){
        return SessionContext.getInstance().getUserLoggedIn();
    }
    
}