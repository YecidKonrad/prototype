package com.prototype.service.impl;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.dto.ActivityDto;
import com.prototype.dto.TaskDto;
import com.prototype.dto.UserDto;
import com.prototype.service.ActivityService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReporteService {
	@Autowired
	ActivityService activityService;

    public List<Object> listObjExcel = new ArrayList<>();

    public boolean generateExcel(String fileName) {
        List<ActivityDto> activities = activityService.getAllActivitiesDetails();

        try {
            Workbook wb = new SXSSFWorkbook();
            Sheet sheet = wb.createSheet("Activities");

            // Crear el formato de fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm a");

            // Crear la cabecera
            String[] headers = {"idActivity", "tittle", "description", "startDuration", "createdDate", "priority",
                "idStateActivity", "stateActivity", "createdBy", "createdBy-fullName", "createdBy-username",
                "createdBy-email", "createdBy-institution", "createdBy-active",
                "idTask", "tittle", "description", "startDuration", "endDuration", "createdDate",
                "createdBy-username", "createdBy-email", "createdBy-institution", "createdBy-active",
                "idStateTask", "state", "idUser", "createdBy-fullName",
                "createdBy-email", "createdBy-institution", "createdBy-active"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                CellStyle style = wb.createCellStyle();
                style.setFillForegroundColor(IndexedColors.YELLOW.getIndex()); // Color de fondo amarillo claro
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(style);
            }

            // Llenar los datos
            int rowNum = 1;
            for (ActivityDto activity : activities) {
                List<TaskDto> assignedTasks = activity.getTasksAsignedToActivity();
                List<UserDto> assignedUsers = activity.getUsersAsignedToActivity();

                // Si hay tareas asignadas
                if (!assignedTasks.isEmpty()) {
                    for (TaskDto task : assignedTasks) {
                        Row row = sheet.createRow(rowNum);

                        // Llenar los datos de la actividad
                        row.createCell(0).setCellValue(activity.getIdActivity());
                        row.createCell(1).setCellValue(activity.getTittle());
                        row.createCell(2).setCellValue(activity.getDescription());
                        row.createCell(3).setCellValue(dateFormat.format(activity.getStartDuration()));
                        row.createCell(4).setCellValue(dateFormat.format(activity.getCreatedDate()));
                        row.createCell(5).setCellValue(activity.getPriority());
                        row.createCell(6).setCellValue(activity.getStateActivity().getIdStateActivity());
                        row.createCell(7).setCellValue(activity.getStateActivity().getState());
                        row.createCell(8).setCellValue(activity.getCreatedBy().getIdUser());
                        row.createCell(9).setCellValue(activity.getCreatedBy().getFullName());
                        row.createCell(10).setCellValue(activity.getCreatedBy().getUsername());
                        row.createCell(11).setCellValue(activity.getCreatedBy().getEmail());
                        row.createCell(12).setCellValue(activity.getCreatedBy().getInstitution());
                        row.createCell(13).setCellValue(activity.getCreatedBy().isActive());

                        // Llenar los datos de la tarea asignada
                        row.createCell(14).setCellValue(task.getIdTask());
                        row.createCell(15).setCellValue(task.getTittle());
                        row.createCell(16).setCellValue(task.getDescription());
                        row.createCell(17).setCellValue(dateFormat.format(task.getStartDuration()));
                        row.createCell(18).setCellValue(dateFormat.format(task.getEndDuration()));
                        row.createCell(19).setCellValue(dateFormat.format(task.getCreatedDate()));
                        row.createCell(20).setCellValue(task.getCreatedBy().getUsername());
                        row.createCell(21).setCellValue(task.getCreatedBy().getEmail());
                        row.createCell(22).setCellValue(task.getCreatedBy().getInstitution());
                        row.createCell(23).setCellValue(task.getCreatedBy().isActive());
                        row.createCell(24).setCellValue(task.getStateTask().getIdStateTask());
                        row.createCell(25).setCellValue(task.getStateTask().getState());

                        // Aplicar color de fondo verde claro a las celdas de tarea
                        for (int i = 14; i <= 25; i++) {
                            CellStyle style = wb.createCellStyle();
                            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex()); // Color de fondo verde claro
                            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                            row.getCell(i).setCellStyle(style);
                        }

                        rowNum++;
                    }
                }

                // Si hay usuarios asignados
                if (!assignedUsers.isEmpty()) {
                    for (UserDto user : assignedUsers) {
                        Row row = sheet.createRow(rowNum);

                        // Llenar los datos de la actividad
                        row.createCell(0).setCellValue(activity.getIdActivity());
                        row.createCell(1).setCellValue(activity.getTittle());
                        row.createCell(2).setCellValue(activity.getDescription());
                        row.createCell(3).setCellValue(dateFormat.format(activity.getStartDuration()));
                        row.createCell(4).setCellValue(dateFormat.format(activity.getCreatedDate()));
                        row.createCell(5).setCellValue(activity.getPriority());
                        row.createCell(6).setCellValue(activity.getStateActivity().getIdStateActivity());
                        row.createCell(7).setCellValue(activity.getStateActivity().getState());
                        row.createCell(8).setCellValue(activity.getCreatedBy().getIdUser());
                        row.createCell(9).setCellValue(activity.getCreatedBy().getFullName());
                        row.createCell(10).setCellValue(activity.getCreatedBy().getUsername());
                        row.createCell(11).setCellValue(activity.getCreatedBy().getEmail());
                        row.createCell(12).setCellValue(activity.getCreatedBy().getInstitution());
                        row.createCell(13).setCellValue(activity.getCreatedBy().isActive());

                        // Llenar los datos del usuario asignado
                        row.createCell(26).setCellValue(user.getIdUser());
                        row.createCell(27).setCellValue(user.getFullName());
                        row.createCell(28).setCellValue(user.getEmail());
                        row.createCell(29).setCellValue(user.getInstitution());
                        row.createCell(30).setCellValue(user.isActive());

                        // Aplicar color de fondo morado claro a las celdas de usuario asignado
                        for (int i = 26; i <= 30; i++) {
                            CellStyle style = wb.createCellStyle();
                            style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex()); // Color de fondo morado claro
                            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                            row.getCell(i).setCellStyle(style);
                        }

                        rowNum++;
                    }
                }

                // Aplicar color de fondo amarillo claro a las celdas de actividad
                for (int i = 0; i <= 13; i++) {
                    CellStyle style = wb.createCellStyle();
                    style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex()); // Color de fondo amarillo claro
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    sheet.getRow(rowNum - assignedTasks.size() - assignedUsers.size()).getCell(i).setCellStyle(style);
                }
            }

            // Guardar el archivo
            FileOutputStream fileOut = new FileOutputStream(fileName);
            wb.write(fileOut);
            fileOut.close();
            wb.close();

            return true;
        } catch (IOException e) {
           System.out.println(e.getMessage());
            return false;
        }
    }




    private void fillDataExcel(){
        for (int i = 0; i <= 500; i++) {
            Object[] objBody = {"Nombre "+i,"Apellido "+i,"Calle "+i};
            listObjExcel.add(objBody);
        }
    }
    
    private void setCellBackgroundColors(Sheet sheet, int startRow, int endRow, int columnIndex, String color) {
        Workbook workbook = sheet.getWorkbook();
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.valueOf(color.toUpperCase()).getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int rowNumber = startRow; rowNumber <= endRow; rowNumber++) {
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(columnIndex);
            cell.setCellStyle(style);
        }
    }


}
