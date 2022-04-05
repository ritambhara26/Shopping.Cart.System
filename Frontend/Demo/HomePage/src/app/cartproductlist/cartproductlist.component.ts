import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-cartproductlist',
  templateUrl: './cartproductlist.component.html',
  styleUrls: ['./cartproductlist.component.css']
})
export class CartproductlistComponent implements OnInit {

  productid:any;
  singleProdList:Product;

  constructor(private router:ActivatedRoute, private productService: ProductService) { }

  ngOnInit(): void {
    let prodid = this.router.snapshot.paramMap.get('productid');
    this.productid = prodid;
    console.log(this.productid);
    this.getProductDetailsById();
  }

  getProductDetailsById()
  {
    this.productService.getproductbyid(this.productid).subscribe((res:any)=>
    {
      console.log(res);
      this.singleProdList = res;
    })
  }

}
