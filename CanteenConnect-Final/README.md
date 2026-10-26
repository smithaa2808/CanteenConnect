# Canteen Connect — Member 4

Implements the Member 4 features from the workflow document:
- Order tracking and current status
- Order ID display
- Order history and reorder
- Notifications
- Feedback and rating

## Files included

- `order-tracking.html`, `order-history.html`, `notifications.html`, `feedback.html` (in `src/main/resources/static/`)
- `OrderTracking.java`, `OrderHistory.java`, `Notification.java`, `Feedback.java`, `Rating.java` (entities)
- Corresponding repositories, services, and controllers
- `pom.xml` and `application.properties`

## Run locally

Requirements: JDK 17+ and Maven 3.6+.

1. Extract the ZIP.
2. Open a terminal in the `CanteenConnect-Member4` folder.
3. Run `mvn spring-boot:run`.
4. Open `http://localhost:8080/order-tracking.html`.
5. Place a demo order, use the status selector to progress it, then check history and notifications. Submit feedback with the generated order ID.

The H2 database is stored locally under `./data/member4db`.

## API endpoints

- `GET /api/orders`
- `GET /api/orders/{orderId}`
- `POST /api/orders` with `{"itemSummary":"Veg sandwich x 1"}`
- `PATCH /api/orders/{orderId}/status` with `{"status":"Preparing"}`
- `GET /api/order-history`
- `GET /api/notifications`
- `PATCH /api/notifications/{id}/read`
- `GET /api/feedback`
- `POST /api/feedback` with `{"orderId":"CC12345","comments":"Good food","rating":5}`
- `GET /api/ratings`

Allowed statuses: `Order Placed`, `Accepted`, `Preparing`, `Ready for Pickup`, `Picked Up`.

## Important integration note

This is a self-contained Member 4 starter project with a demo database so it can be run independently. Your team's actual repository may already define orders, notifications, security, package names, or API routes. Before copying these files into the shared repository, ask your team lead for the current source code and merge only the compatible pieces. Do not replace the team's existing `Order` entity, database configuration, authentication, or shared files blindly. The demo status-update endpoint has no authentication and must be protected by the team's Spring Security rules before production use. Real push notifications are not configured; this version stores in-app notification records.
