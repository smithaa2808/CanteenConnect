package com.canteenconnect.member4.controller;
import com.canteenconnect.member4.entity.OrderTracking;import com.canteenconnect.member4.service.OrderTrackingService;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/orders") @CrossOrigin
public class OrderTrackingController {
 private final OrderTrackingService service; public OrderTrackingController(OrderTrackingService service){this.service=service;}
 public record CreateOrderRequest(String itemSummary){} public record StatusRequest(String status){}
 @GetMapping public List<OrderTracking> all(){return service.all();}
 @GetMapping("/{orderId}") public OrderTracking get(@PathVariable String orderId){return service.get(orderId);}
 @PostMapping public OrderTracking create(@RequestBody CreateOrderRequest req){return service.create(req.itemSummary());}
 @PatchMapping("/{orderId}/status") public OrderTracking update(@PathVariable String orderId,@RequestBody StatusRequest req){return service.updateStatus(orderId,req.status());}
}
