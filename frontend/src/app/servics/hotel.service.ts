import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class HotelService {
  private baseURL : string='http://localhost:8080'; 
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }

  getHotels(){
    return this._http.get(this.baseURL+'/hotels', this.options)
    .map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteHotel(id:string){
    return this._http.delete(this.baseURL+'/hotels/'+id, this.options)
    .map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR"); 
  }

  updateHotel(){

  }
}
