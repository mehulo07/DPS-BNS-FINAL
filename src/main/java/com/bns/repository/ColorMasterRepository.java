package com.bns.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.bns.mapper.ColorMasterMapper;
import com.bns.model.ColorMaster;

@PropertySource(value = "classpath:ColorMaster.properties")
@Repository
public class ColorMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Environment propSource;
		
	public List<ColorMaster> getAllColorList(){
		return jdbcTemplate.query(propSource.getProperty("getAllColor"), new ColorMasterMapper());
	}
	
	public ColorMaster getColorDetailById(String colorId) {
		return jdbcTemplate.queryForObject(propSource.getProperty("getColorById"), new Object[] { colorId },
				new ColorMasterMapper());
	}

	public boolean addColor(ColorMaster colorMaster) {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		
		return jdbcTemplate.update(propSource.getProperty("addColor"), colorMaster.getColorId(),
				colorMaster.getColorCode(), colorMaster.getColorName(), colorMaster.getStatus(),
				authentication.getName()) > 0;
	}

	public boolean inactiveColor(String colorId) throws SQLException {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
			return jdbcTemplate.update(propSource.getProperty("inactiveColor"), authentication.getName(), colorId) > 0;
	}

	public boolean updateColor(ColorMaster colorMaster, String colorId) {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		
		return jdbcTemplate.update(propSource.getProperty("updateColor"), colorMaster.getColorCode(),
				colorMaster.getColorName(), colorMaster.getStatus(), authentication.getName(), colorId) > 0;
	}
		
}
