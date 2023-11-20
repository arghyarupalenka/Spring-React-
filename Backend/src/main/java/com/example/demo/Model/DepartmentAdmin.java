package com.example.demo.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;




@jakarta.persistence.Entity
@jakarta.persistence.Table(name="department_admin")
public class DepartmentAdmin implements UserDetails{
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	@Column(unique = true)
	private String email;
	
	private String deptName;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public DepartmentAdmin() {
		super();
	}
	public DepartmentAdmin(Long deptId, String email, String deptName, String password, Role role) {
		super();
		this.deptId = deptId;
		this.email = email;
		this.deptName = deptName;
		this.password = password;
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getEmail() {
		return email;
	}
	public void setDept_email(String email) {
		this.email = email;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
	@Override
	public String toString() {
		return "Department_Admin [deptId=" + deptId + ", email=" + email + ", deptName=" + deptName
				+ ", password=" + password + "]";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.name()));
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
