import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'appBypassSecurity'
})
export class BypassSecurityPipe implements PipeTransform {
  constructor(public domSanitizer: DomSanitizer) {}

  public transform(value: string): SafeHtml {
    return this.domSanitizer.bypassSecurityTrustHtml(value);
  }
}
