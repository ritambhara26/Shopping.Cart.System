import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import {Product} from 'src/app/model/product';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
producturl: String ="http://localhost:8081/getproduct/product";
  constructor(private http:HttpClient) { }
  getAllProd(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.producturl}`);
  }
  postProduct(product:any)
  {
    return this.http.post<any>("http://localhost:3000/posts",product).pipe(map((res:any)=>{
      return res;
    }))
  }
  
  //get
  getProduct()
  {
    return this.http.get<any>("http://localhost:3000/posts").pipe(map((res:any)=>{
      return res;
    }))
  }

  //update
  updateProduct(product:any, productid:number)
  {
    return this.http.put<any>("http://localhost:3000/posts/"+productid, product).pipe(map((res:any)=>{
      return res;
    }))
  }

  //delete
  deleteProduct(productid:number)
  {
    return this.http.delete<any>("http://localhost:3000/posts/"+productid).pipe(map((res:any)=>{
      return res;
    }))
  } 
}
