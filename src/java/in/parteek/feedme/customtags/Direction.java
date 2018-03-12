package in.parteek.feedme.customtags;

import in.parteek.feedme.logic.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.net.*;

/**
 *
 * Created on : 3-Jan-2018, 1:32:13 AM
 *
 * @author Parteek Dheri
 */
public class Direction extends SimpleTagSupport {

    private Restaurant restaurant;

    public Direction() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String destination = URLEncoder.encode(restaurant.getVicinity(), "UTF-8");
        String url = "https://www.google.com/maps/dir/?"
                + "api=1"
                + "&origin=My+Location"
                + "&destination=" + destination
                + "&destination_place_id=" + restaurant.getPlace_id();

        String result = " " + "<a href=\"" + url + "\" target=\"_blank\"> " + restaurant.getName() + "</a>";
        out.println(result);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
