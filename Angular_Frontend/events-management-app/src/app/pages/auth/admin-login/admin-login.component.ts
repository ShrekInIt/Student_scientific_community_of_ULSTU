import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { LoginRequest } from '../../../models/user.model';

@Component({
  selector: 'app-admin-login',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.scss']
})
export class AdminLoginComponent implements OnInit {
  adminForm: FormGroup;
  adminLoading = false;
  adminError = '';

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.adminForm = this.fb.group({
      email: ['', [Validators.required, Validators.email, this.adminEmailValidator]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  ngOnInit(): void {
    // If already logged in, redirect to appropriate dashboard
    if (this.authService.isLoggedIn()) {
      const user = this.authService.getCurrentUser();
      if (user && user.role === 'ADMIN') {
        this.router.navigate(['/admin/dashboard']);
      } else {
        this.router.navigate(['/']);
      }
    }
  }

  // Custom validator for admin email
  adminEmailValidator(control: any) {
    const email = control.value;
    if (email && !email.endsWith('@admin.org')) {
      return { adminEmail: true };
    }
    return null;
  }

  onAdminLogin() {
    this.adminError = '';
    if (this.adminForm.invalid) {
      this.adminError = 'Пожалуйста, заполните все поля корректно.';
      return;
    }
    this.adminLoading = true;
    const loginRequest: LoginRequest = {
      email: this.adminForm.value.email,
      password: this.adminForm.value.password
    };
    this.authService.login(loginRequest).subscribe({
      next: (response) => {
        const user = response.user;
        if (user && user.role === 'ADMIN') {
          this.router.navigate(['/admin/dashboard']);
        } else {
          this.adminError = 'Нет прав администратора.';
        }
        this.adminLoading = false;
      },
      error: (err) => {
        this.adminError = 'Ошибка входа. Проверьте email и пароль.';
        this.adminLoading = false;
      }
    });
  }

  contactSupport(): void {
    // Navigate directly to support page's contact information section
    this.router.navigate(['/support'], { fragment: 'contact-info' });
  }

  goBackToLanding(): void {
    this.router.navigate(['/']); // Navigate to home component instead of signin
  }

  private markFormGroupTouched(): void {
    Object.keys(this.adminForm.controls).forEach(key => {
      const control = this.adminForm.get(key);
      control?.markAsTouched();
    });
  }
}
