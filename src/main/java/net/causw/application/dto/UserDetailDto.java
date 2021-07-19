package net.causw.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.causw.domain.model.UserDomainModel;
import net.causw.infra.User;

@Getter
@NoArgsConstructor
public class UserDetailDto {
    private String id;
    private String email;
    private String name;
    private Integer admissionYear;
    private String role;
    private String profileImage;
    private Boolean isBlocked;

    private UserDetailDto(
            String id,
            String email,
            String name,
            Integer admissionYear,
            String role,
            String profileImage,
            Boolean isBlocked
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.admissionYear = admissionYear;
        this.role = role;
        this.profileImage = profileImage;
        this.isBlocked = isBlocked;
    }

    public static UserDetailDto from(User user) {
        return new UserDetailDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getAdmissionYear(),
                user.getRole().getValue(),
                user.getProfileImage(),
                user.getIsBlocked()
        );
    }

    public static UserDetailDto from(UserDomainModel user) {
        return new UserDetailDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getAdmissionYear(),
                user.getRole(),
                user.getProfileImage(),
                user.getIsBlocked()
        );
    }
}