# BackendForUsersStore
This is a Backend for Users store

FUNCTIONALITY:
1) adding new user by registration form
2) password of recently created user will encode by BCryptPasswordEncoder with strenth 12
3) add users different permissions depends on its roles. Admin-user has access to admin-page. For plain user this page is restricted
4) logout proccess passes like post-method. JSESSION cookie and other session data removed.

IN PROGRES:
1) administration. CRUD functioanlity from apmin-page.

LATER:
1) add auto changing user-status if user in not active in 5 minutes
2) JWT-token functional


ACTUAL BUGS:
1) Create new user via registration form. After redirect to login page try to sign in with recently created user's nickname and password. you will redirect to "8081:/login" with PAGE NOT FOUND ERROR.


UNCORRECT WORK:
1) creating new user by postman (post-method /api/v1/users/admin/). New users ID starts from 1, despite the fact that there is already exist User with the same id in DB 


DOESN'T WORK:
1) deleting user by postman (delete-method /api/v1/users/admin/{id})

DOESN'T CHECK:
1) updating user by postman delete-method 
