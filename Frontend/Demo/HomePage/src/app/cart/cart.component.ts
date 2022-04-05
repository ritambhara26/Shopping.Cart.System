import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart.service';




@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  public totalItem : number = 0;
  public products: any = [];
  public grandTotal: number;

  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem=res.length;
      this.products=res;
      this.grandTotal=this.cartService.getTotalPrice()

    })
    }
    removeItem(product:any){
      this.cartService.removeCartItem(product);
    }

    emptycart(){
      this.cartService.removeAllCart();
    }

  
}