package ua.com.masterpol.navigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Oxana on 29.08.2015.
 */
@ManagedBean(name = "navigator")
@RequestScoped
public class NavigationBean {
    public String gotoListProducts(){
        return "default?faces-redirect=true";
    }
}
