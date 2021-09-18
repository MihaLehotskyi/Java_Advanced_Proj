package ua.lviv.lgs.abit.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

//import antlr.StringUtils;
import ua.lviv.lgs.abit.domain.Abiturient;

public class CustomAbiturientDetails extends Abiturient implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private List<String> userRoles;
	
	public CustomAbiturientDetails(Abiturient abit, List<String> userroles){
		super(abit);
		this.userRoles = userroles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getUsername() {
		return super.getFirstname();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
