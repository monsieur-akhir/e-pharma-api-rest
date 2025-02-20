
/*
 * Created on 2024-02-19 ( Time 10:54:59 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;

/**
 * Functional Error
 *
 * @author Geo
 *
 */
@Data
@ToString
@NoArgsConstructor
@XmlRootElement
@Component
public class FunctionalError {
	private String code;
	private String message;
	@Autowired
	private MessageSource messageSource;

	private static Status status = new Status();

	public Status SUCCESS(String message, Locale locale) {
		status.setCode(StatusCode.SUCCESS);
		status.setMessage(messageSource.getMessage("StatusMessage.SUCCESS", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status ALREADY_TREATY(String message, Locale locale) {
		status.setCode(StatusCode.SUCCESS);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_DATA_TREATY", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status UNEXPECTED_ERROR2(String message, Locale locale) {
		status.setCode(StatusCode.TECH_INTERN_ERROR);
		status.setMessage(messageSource.getMessage("StatusMessage.TECH_INTERN_ERROR", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}


	public Status UNAUTHORIZED_APPROVAL(String message, Locale locale) {
		status.setCode(StatusCode.SUCCESS);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_UNAUTHORIZED_APPROVAL", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status AUTH_FAIL(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_AUTH_FAIL);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_AUTH_FAIL", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status DATA_NOT_EXIST(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATA_NOT_EXIST);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_DATA_NOT_EXIST", new Object[] {}, normalizeLocale(locale)) + ": "
				+ message);
		return status;
	}

	public Status DATA_TOO_LONG(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATA_TOO_LONG);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_DATA_TOO_LONG", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status DATA_EMPTY(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATA_EMPTY);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_DATA_EMPTY", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status DATA_EXIST(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATA_EXIST);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_DATA_EXIST", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status INVALID_CODE_LANGUAGE(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_INVALID_CODE_LANGUAGE);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_INVALID_CODE_LANGUAGE", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}


	public Status FIELD_EMPTY(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_FIELD_EMPTY);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_FIELD_EMPTY", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status SEESION_EXPIRER(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_FIELD_EMPTY);
		status.setMessage("Session Expirer");
		return status;
	}

	public Status USER_ALREADY_CONNECTED(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_USER_ALREADY_CONNECTED);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_USER_ALREADY_CONNECTED", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status USER_IS_UNLOCKED(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_USER_IS_LOCKED);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_USER_IS_UNLOCKED", new Object[] {}, normalizeLocale(locale)) + ": "
				+ message);
		return status;
	}

	public Status REQUEST_FAIL(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_REQUEST_FAIL);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_REQUEST_FAIL", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status UNEXPECTED_ERROR(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_FAIL);
		status.setMessage(messageSource.getMessage("StatusMessage.UNEXPECTED_ERROR", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status SAVE_FAIL(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_SAVE_FAIL);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_SAVE_FAIL", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status TYPE_NOT_CORRECT(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_TYPE_NOT_CORRECT);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_TYPE_NOT_CORRECT", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status DATE_FORMAT_NOT_CORRECT(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATE_FORMAT_NOT_CORRECT);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_DATE_FORMAT_NOT_CORRECT", new Object[] {}, normalizeLocale(locale)) + ": "
						+ message);
		return status;
	}

	public Status INVALID_DATE_PERIOD(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_INVALID_DATE_PERIOD);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_INVALID_DATE_PERIOD", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status INVALID_FORMAT(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_INVALID_FORMAT);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_INVALID_FORMAT", new Object[] {}, normalizeLocale(locale)) + ": "
				+ message);
		return status;
	}

	public Status INVALID_ENTITY_NAME(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_INVALID_ENTITY_NAME);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_INVALID_ENTITY_NAME", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status IMEI_INCORRECT(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_IMEI_INCORRECT);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_IMEI_INCORRECT", new Object[] {}, normalizeLocale(locale)) + ": "
				+ message);
		return status;
	}

	public Status FUNC_ONE_MUST_BE_FIELD_EMPTY(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_ONE_MUST_BE_FIELD_EMPTY);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_ONE_MUST_BE_FIELD_EMPTY", new Object[] {}, normalizeLocale(locale)) + ": "
						+ message);
		return status;
	}

	public Status FUNC_PERCENT_VALUE(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_MUST_BE_INFERIOR_TO_100);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_MUST_BE_INFERIOR_TO_100", new Object[] {}, normalizeLocale(locale)) + ": "
						+ message);
		return status;
	}

	public Status FILE_GENERATION_ERROR(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_FILE_GENERATION_ERROR);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_FILE_GENERATION_ERROR", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status LOGIN_FAIL(Locale locale) {
		status.setCode(StatusCode.FUNC_LOGIN_FAIL);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_LOGIN_FAIL", new Object[] {}, normalizeLocale(locale)));
		return status;
	}

	public Status DISALLOWED_OPERATION(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_FILE_GENERATION_ERROR);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_DISALLOWED_OPERATION", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status DATA_NOT_DELETABLE(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATA_NOT_DELETABLE);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_DATA_NOT_DELETABLE", new Object[] {}, normalizeLocale(locale))
				+ ": " + message);
		return status;
	}

	public Status DATA_DUPLICATE(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_DATA_DUPLICATE);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_DATA_DUPLICATE", new Object[] {}, normalizeLocale(locale)) + ": "
				+ message);
		return status;
	}

	public Status USER_IS_LOCKED(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_USER_IS_LOCKED);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_USER_IS_LOCKED", new Object[] {}, normalizeLocale(locale)) + ": "
				+ message);
		return status;
	}

	public Status SESSION_EXPIRED(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_SESSION_EXPIRED);
		status.setMessage(
				messageSource.getMessage("StatusMessage.FUNC_SESSION_EXPIRED", new Object[] {}, normalizeLocale(locale)) + "" + message);
		return status;
	}

	public Status NO_USER(String message, Locale locale) {
		Status status = new Status();
		status.setCode(StatusCode.FUNC_FIELD_EMPTY);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_FIELD_EMPTY", new Object[] {}, normalizeLocale(locale)) + message);
		return status;
	}

	public Status SESSION_EXPIRER(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_SESSION_EXPIRED);
		status.setMessage("Session Expirée");
		return status;
	}



	public Status ECHEC_GEL_TRANSACTION(String message, Locale locale) {
		status.setCode(StatusCode.FUNC_ECHEC_GEL_TRANSACTION);
		status.setMessage("Echec du gel de transaction ");
		return status;
	}

	public Status INVALID_VALUE( String message, Locale locale) {
		status.setCode(StatusCode.FUNC_INVALID_VALUE);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_INVALID_VALUE", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status INVALID_TOKEN( String message, Locale locale) {
		status.setCode(StatusCode.FUNC_INVALID_TOKEN);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_INVALID_TOKEN", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status UNAUTHORIZED_ACCESS( String message, Locale locale) {
		status.setCode(StatusCode.FUNC_UNAUTHORIZED_ACCESS);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_UNAUTHORIZED_ACCESS", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status PERMISSION_DENIED( String message, Locale locale) {
		status.setCode(StatusCode.FUNC_PERMISSION_DENIED);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_PERMISSION_DENIED", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}



	public Status TECH_INTERN_ERROR( String message, Locale locale) {
		Locale normalizedLocale = normalizeLocale(locale);
		status.setCode(StatusCode.TECH_INTERN_ERROR);
		status.setMessage(messageSource.getMessage("StatusMessage.TECH_INTERN_ERROR", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status ECHEC_TRANSACTION( String message, Locale locale) {
		Locale normalizedLocale = normalizeLocale(locale);
		status.setCode(StatusCode.FUNC_ECHEC_TRANSACTION);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_ECHEC_TRANSACTION", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status EXTRATION_ERROR( String message, Locale locale) {
		Locale normalizedLocale = normalizeLocale(locale);
		status.setCode(StatusCode.EXTRATION_ERROR);
		status.setMessage(messageSource.getMessage("StatusMessage.EXTRATION_ERROR", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status INVALID_PIN( String message, Locale locale) {
		Locale normalizedLocale = normalizeLocale(locale);
		status.setCode(StatusCode.FUNC_INVALID_PIN);
		status.setMessage(messageSource.getMessage("StatusMessage.INVALID_PIN", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	public Status ACCESS_DENIED (String message, Locale locale) {
		Locale normalizedLocale = normalizeLocale(locale);
		status.setCode(StatusCode.FUNC_ACCESS_DENIED);
		status.setMessage(messageSource.getMessage("StatusMessage.FUNC_ACCESS_DENIED", new Object[] {}, normalizeLocale(locale)) + ": " + message);
		return status;
	}

	private Locale normalizeLocale(Locale locale) {
		if (locale != null) {
			String language = locale.getLanguage().toLowerCase(); // Convertit en minuscule
			if (language.startsWith("fr")) {
				return Locale.FRENCH; // Normalise en "fr"
			} else if (language.startsWith("en")) {
				return Locale.ENGLISH; // Normalise en "en"
			}
		}
		return locale; // Retourne la locale originale si aucune correspondance
	}

}