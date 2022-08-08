package controller;

import model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import repositories.OrderRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {

    private OrderRepository orderDao;

    public OrderController(OrderRepository orderRepository) {
        this.orderDao = orderDao;
    }

    @GetMapping("/orders/create")
    public String createOrder(Model model) {
        model.addAttribute("newOrder", new Order());
        return "orders/create";
    }

    @PostMapping("/orders/create")
    public String submitOrder(@ModelAttribute Order order) {
       orderDao.save(order);
        return "redirect:/show";
    }

    @GetMapping("/orders")
    public String allOrders(Model vModel) {
        List<Order> order = new ArrayList<>(Arrays.asList());
        vModel.addAttribute("order", order);
        return "orders/show";
    }

    @GetMapping("/orders/{id}")
    public String getOrder(@PathVariable long id, Model vModel) {
        Order order = orderDao.findById(id).get();
        vModel.addAttribute("orders", order);
        return "orders/show";
    }

    @GetMapping("/orders/{id}/edit")
    public String editOrder(@PathVariable long id, Model model) {
        Order order = orderDao.findById(id).get();
        model.addAttribute("orders", order);
        return "orders/modify";
    }

    @PostMapping("/orders/{id}/edit")
    public String submitEditOrder(@ModelAttribute Order order) {
        orderDao.save(order);
        return "redirect:/show";
    }


    @GetMapping("orders/delete/")
    public String deleteProduct(){
        orderDao.deleteById(14L);
        return "redirect:/show";
    }



}
