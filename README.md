# angular-h5style

## background

https://blog.csdn.net/lvxinaidou/article/details/106544158



## step

1. page-src init from: https://stackblitz.com/edit/angular-c32pnf?file=src%2Fapp%2Fapp.module.ts

2. then https://angular.cn/guide/router#adding-components-for-routing

3. npm install

4. RouterModule.forRoot(routes, { useHash: false })

5. npm run build

6. after build the project need change index.html 

   ```
   <base href="/dist/"/>
   ```

7. java properties: spring.resources.static-locations=classpath:templates/



## link

http://localhost:8080/dist/index.html

