import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { map, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl="http://localhost:8081/getproduct/product";
 

  constructor(private http:HttpClient) { }
  getAllProd(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}`);
  }
  postProduct(product:Product): Observable<Product[]>
  {
    return this.http.post<Product[]>("http://localhost:8081/getproduct/product",product)
    
  }
  
  //get
  getProduct()
  {
    return this.http.get<any>("http://localhost:8081/getproduct").pipe(map((res:any)=>{
      return res;
    }))
  }

  //update
  updateProduct(product:any, productid:number)
  {
    return this.http.put<any>("http://localhost:8081/getproduct/product/"+productid, product).pipe(map((res:any)=>{
      return res;
    }))
  }

  //delete
  deleteProduct(productid:number)
  {
    return this.http.delete<any>("http://localhost:8081/getproduct/product/"+productid).pipe(map((res:any)=>{
      return res;
    }))
  } 
  getproductbyid(productid:number):Observable<Product>
  {
    return this.http.get<any>("http://localhost:8081/getproduct/product/"+productid);
  }
}
