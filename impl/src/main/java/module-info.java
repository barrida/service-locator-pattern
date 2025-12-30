module com.example.impl {
    requires com.example.api;
    provides com.example.api.UserService with com.example.impl.UserServiceImpl;
}