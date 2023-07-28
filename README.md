# FoodDeliveryPlateform
-------
## Framework and Language used
  + SpringBoot
  + JAVA
  + SQL
-------
## Data Flow
  + controller
      - AdminController
      - CustomerController
  + model
       + dto
           - SignInInput
           - SignUpOutput
       + enums
           - DeliveryType
       + Address
       + Admin
       + AuthenticationToken
       + Customer
       + FoodCart
       + FootCategory
       + Item
       + Order
   + repository
      - IAddressRepo
      - IAdminRepo
      - IAuthenticationTokenRepo
      - ICustomerRepo
      - IFoodCartRepo
      - IFoodCatRepo
      - IItemRepo
      - IOrderRepo
  + service
      + utility
          + emailUtility
              - EmailHandler
          + hashingUtility
              - PasswordEncrypter
      - AddressService
      - AdminService
      - AuthenticationService
      - CartService
      - CategoryService
      - CustomerService
      - ItemService
      - OrderService
      - RestaurantService
  + FoodDeliveryBackendApplication(main class)
---------
## Data Structure used
  + List
-------
## Database Used
   + MySQL
---------
## Project Summary 
This is a simple backend Design of a online food delivery platform. In this application admin will responsible for CRUD operations like
add/get/update/ delete food item , restaurnts etc. Customer can only see the list of restaurants and food items with details.
Also customer can add food item to cart and then place order. Admin Shold be authenticated. If customer using this application for the
first time then they need to sign up and existing users can sign in. 
