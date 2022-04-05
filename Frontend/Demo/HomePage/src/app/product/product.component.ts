import { Component, OnInit } from '@angular/core';
import {ProductService} from '../product.service'
import { Product } from '../product';
import { FormGroup, FormBuilder} from '@angular/forms';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

   products:Product[];
  
  formValue!: FormGroup
  productModelObject: Product = new Product;
  showAdd: boolean;
  showBtn: boolean;
  api: any;
  allproductData: any;
  
  constructor(private formBuilder: FormBuilder, private productService:ProductService,private route: Router) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group(
      {
        productname: [''],
        description: [''],
        prodimage: [''],
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
  this.route.navigate(['/home',data.productid]);
}
  //subscribe
  addProduct() {
    this.productModelObject.productid=this.formValue.value.productid;
    this.productModelObject.productname= this.formValue.value.productname;
    this.productModelObject.prodimage=this.formValue.value.prodimage;
    this.productModelObject.description = this.formValue.value.description;
    this.productModelObject.quantity = this.formValue.value.quantity;
    this.productModelObject.price = this.formValue.value.price;
    

    this.productService.postProduct(this.productModelObject).subscribe((res:any[]) => {
      console.log(res);
      Swal.fire(
        "Product Added",
        "Successfully",
        "success"
      )
      this.formValue.reset();
      this.getProduct();
    }
      , err => {
        alert("Error Occured");
      })
  }


 

  //delete
  deleteprod(product:any)
  {
    this.productService.deleteProduct(product.productid).subscribe((res:any[])=>{
      Swal.fire({
        title: "Are you sure?",
        text: "You want to delete",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
      })
      this.getProduct();
    })
  }

  //edit
  onEditprod(product:any)
  {
    this.showAdd=false;
    this.showBtn=true;
    this.productModelObject.productid = product.productid;
    this.formValue.controls['productname'].setValue(product.productname);
    this.formValue.controls['prodimage'].setValue(product.prodimage);
    this.formValue.controls['description'].setValue(product.description);
    this.formValue.controls['quantity'].setValue(product.quantity);
    this.formValue.controls['price'].setValue(product.price);
  }

  updateProduct()
  {
    this.productModelObject.productname = this.formValue.value.productname;
    this.productModelObject.description = this.formValue.value.description;
    this.productModelObject.prodimage = this.formValue.value.prodimage;
    this.productModelObject.quantity = this.formValue.value.quantity;
    this.productModelObject.price = this.formValue.value.price;
   

    this.productService.updateProduct(this.productModelObject, this.productModelObject.productid)
    .subscribe((res:any[])=>{
      Swal.fire(
        "Product Updated",
        "Successfully",
        "success"
      )
      this.getProduct();
    }

    );
  }
  onSelectionFile(event:any){
    const reader = new FileReader();

   

    if(event.target.files && event.target.files.length) {

      const [file] = event.target.files;

      reader.readAsDataURL(file);
      retrievedImage: this.getProduct;
   
    
      reader.onload = () => {

     

        this.formValue.patchValue({

          prodimage: reader.result
          
        });
        //this.getProduct();

  }
 }
  }
}
