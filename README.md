# AnnotationWebAppSpring
An annotation system as web service in Spring.

A lot of code has been extracted from the tutorial https://www.callicoder.com/spring-boot-spring-security-jwt-mysql-react-app-part-1/ for educational purposes.

The app consists in, a user has annotation groups, and annotation groups has annotations. The annotation groups have a title, color and tags. The annotations have text, color, title and tags.

The functioning of that app is:
1. Login with a user

   /api/auth/signin  
   Is a POST request, the fields are:
```javascript
   {
     usernameOrEmail : String,
     password : String
   }
```
2. Create a user

   /api/auth/signup  
   Is a POST request, the fields are:
```javascript
   {
     email : String,
     password : String
   }
```
3. Show all annotation groups of the current user logged.

   /api/annotationgroups  
   Is a response, the fields are:
```javascript
   {
     email : string,
     annotationGroups : [
       { title : String,
         color : String,
         tags : [String, String, ...] }, ...
     ]
   }
```
4. (RESPONSE) Show all annotations of a annotation group.

   /api/annotationgroups/{annotationGroupId}  
   Is a response, the fields are:
   ```javascript
   {
      title : String,
      color : String,
      annotations : [
        { text : String,
          color : String,
          title : String,
          tags : [String, ... ] } , ...
      ]
    }
   ```
5. (REQUEST) Create a new annotation for actual annotation group.

   /api/annotationgroups/{annotationGroupId}  
   Is a POST request, the fields are:
   ```javascript
   {
      text : String,
      color : String,
      title : String,
      tags : [String, ... ]
    }
    ``` 
