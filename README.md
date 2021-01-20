# BackendForUsersStore
This is a Backend for Users store

FUNCTIONALITY:
1) Adding new user by registration form
2) Password of recently created user will encode by BCryptPasswordEncoder with strenth 12
3) Add users different permissions depends on its roles. Admin-user has access to admin-page. For plain user this page is restricted
4) Logout proccess passes like post-method. JSESSION cookie and other session data removed.

IN PROGRES:
1) Administration. CRUD functioanlity from apmin-page.

LATER:
1) Add auto changing user-status if user in not active in 5 minutes
2) JWT-token functional
3) Creation pages from admin with html and rooting (роутинг) key. 
  For example - Create page Test with any html and rooting key (/test). Then, if a plaine user sign in, the page (/test) will appear from DB.
4) Write unit-tests for all classes

TO IMPROVE
1) Remove dublicates from userFromDBToRealUserMapper() in SecurityUser
2) Edit @PreAuthorize("hasAuthority('can.write')") with hasPermission() method
3) Add index.html file and all security relates with it


ACTUAL BUGS:
1) Create new user via registration form. After redirect to login page try to sign in with recently created user's nickname and password. you will redirect to "8081:/login" with PAGE NOT FOUND ERROR.


UNCORRECT WORK:
1) Creating new user by postman (post-method /api/v1/users/admin/). New users ID starts from 1, despite the fact that there is already exist User with the same id in DB 

DOESN'T WORK:
1) Deleting user by postman (delete-method /api/v1/users/admin/{id})

DOESN'T CHECK:
1) Updating user by postman delete-method 
