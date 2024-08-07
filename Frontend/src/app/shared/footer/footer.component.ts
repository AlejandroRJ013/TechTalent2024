import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './footer.component.html',
  styles: [
    `
      footer {
        display: inline-flex;
        width: 100%;
        background-color: #1b1b1b;
        padding: 20px 0;
        align-items: center;
        text-align: center;
        border-top: 1px solid #e7e7e7;
      }

      footer p {
        margin: 0;
        margin-left: 2em;
        font-size: 14px;
        color: #fff;
        width: 35%;
      }

      .footer-icons {
        display: flex;
        width: 100%;
        justify-content: space-around;
        margin-top: 5px;
      }

      .footer-icon {
        background-color: #f7d460;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 2px;
        border-radius: 10px;
        position: relative;
      }

      .footer-icon img {
        width: 32px;
        height: 32px;
        cursor: pointer;
        transition: transform 0.3s ease;
      }

      .footer-icon img:hover {
        transform: rotate(35deg) scale(1.3);
      }

      .social-links {
        display: none;
        width: 6em;
        position: absolute;
        bottom: 40px;
        left: 50%;
        transform: translateX(-50%);
        background-color: #fff;
        padding: 10px;
        border: 1px solid #e7e7e7;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        z-index: 10;
      }

      .footer-icon:hover .social-links {
        display: block;
      }

      .social-links a {
        display: block;
        margin: 5px 0;
        color: #007bff;
        text-decoration: none;
      }

      .social-links a:hover {
        text-decoration: underline;
      }
    `,
  ],
})
export class FooterComponent {}
