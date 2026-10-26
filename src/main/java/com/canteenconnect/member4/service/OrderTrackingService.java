package com.canteenconnect.member4.service;

import com.canteenconnect.member4.entity.*;
import com.canteenconnect.member4.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderTrackingService {
    public static final List<String> STATUSES = List.of("Order Placed", "Accepted", "Preparing", "Ready for Pickup", "Picked Up");
    private final OrderTrackingRepository orders; private final OrderHistoryRepository history; private final NotificationRepository notifications;
    public OrderTrackingService(OrderTrackingRepository orders, OrderHistoryRepository history, NotificationRepository notifications) {this.orders=orders;this.history=history;this.notifications=notifications;}
    public List<OrderTracking> all(){return orders.findAll();}
    public OrderTracking get(String orderId){return orders.findByOrderId(orderId).orElseThrow(()->new IllegalArgumentException("Order not found: "+orderId));}
    @Transactional public OrderTracking create(String itemSummary){
        if(itemSummary==null||itemSummary.isBlank()) throw new IllegalArgumentException("Item summary is required");
        String id; do{id="CC"+(10000+(int)(Math.random()*90000));}while(orders.findByOrderId(id).isPresent());
        OrderTracking o=orders.save(new OrderTracking(id,itemSummary.trim(),STATUSES.get(0)));
        notifications.save(new Notification("Order "+id+" has been placed.")); return o;
    }
    @Transactional public OrderTracking updateStatus(String orderId,String status){
        if(!STATUSES.contains(status)) throw new IllegalArgumentException("Invalid status. Use: "+STATUSES);
        OrderTracking o=get(orderId); int current=STATUSES.indexOf(o.getStatus()), next=STATUSES.indexOf(status);
        if(next<current) throw new IllegalArgumentException("Order status cannot move backwards");
        o.setStatus(status); OrderTracking saved=orders.save(o);
        notifications.save(new Notification("Order "+orderId+" status updated to "+status+"."));
        if("Picked Up".equals(status)&&history.findAllByOrderByCompletedAtDesc().stream().noneMatch(h->h.getOrderId().equals(orderId))) history.save(new OrderHistory(orderId,o.getItemSummary(),status));
        return saved;
    }
}
