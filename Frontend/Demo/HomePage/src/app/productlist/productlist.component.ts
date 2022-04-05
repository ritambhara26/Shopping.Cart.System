import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  products:Product[];
  
  formValue!: FormGroup
  productModelObject: Product = new Product;
  showAdd: boolean;
  showBtn: boolean;
  api: any;
  allproductData: any;
  cartService: any;
  productList: any;
  filterCategory: any;
  product: any;
  
  constructor(private formBuilder: FormBuilder, private productService:ProductService, private route: Router) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group(
      {
        productname: [''],
        prodimage:[''],
        description: [''],
        quantity: [''],
        price: ['']
        
      }
    )
    this.getProduct();
    
  }
  clickAddprod()
  {
    this.formValue.reset();
    this.showAdd=true;
    this.showBtn=false;
  }
getProduct(){
  this.productService.getAllProd().subscribe((product: Product[])=> {
    console.log(product);
    this.products=product;
  });
}
onSelect(data:any)
{
  this.route.navigate(['/productlist',data.productid]);
}
// onSelect()
//  {
//    this.route.navigate(['/cart']);
//  }
 addtocart(){
  this.cartService.addtoCart(item);
}
filter(category:string){
  this.filterCategory = this.product
  .filter((a:any)=>{
    if(a.category == category || category==''){
      return a;
    }
  })

}
}
function item(item: any) {
  throw new Error('Function not implemented.');
}

