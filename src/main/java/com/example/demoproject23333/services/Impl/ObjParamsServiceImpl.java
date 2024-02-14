package com.example.demoproject23333.services.Impl;



import com.example.demoproject23333.model.ObjParams;
import com.example.demoproject23333.model.Params;
import com.example.demoproject23333.model.Response;
import com.example.demoproject23333.repositories.ObjParamsRepository;
import com.example.demoproject23333.repositories.ParamsRepository;
import com.example.demoproject23333.repositories.ResponseRepository;
import com.example.demoproject23333.services.ObjParamsService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

//Реализация сервиса для работы с данными устройств
@Service
@RequiredArgsConstructor
public class ObjParamsServiceImpl  implements ObjParamsService {
    private final ObjParamsRepository objParamsRepository;
    private final ParamsRepository paramsRepository;
    private final ResponseRepository responseRepository;


    //Сохранеие данных устройства  в базу данных
    public Response saveResponseFromJson(Response response) {
        return responseRepository.save(response);


    }

    //Преобразует шестнадцатеричный статус устройства в текстовое описание
    public String convertStatus(String objName) {
        List<ObjParams> objParamsList = objParamsRepository.findByObjName(objName);
        StringBuilder statusText = new StringBuilder();

        Optional<ObjParams> ObjParamsWithParams = objParamsList.stream()
                .filter(objParam -> objParam.getParams() != null)
                .reduce((e1, e2) -> e2);

        if (ObjParamsWithParams.isPresent()) {
            Params params = ObjParamsWithParams.get().getParams();
            String hexValue = params.getStatus();
            int intValue = Integer.parseInt(hexValue.substring(2), 16);
            String binaryString = String.format("%16s", Integer.toBinaryString(intValue)).replace(' ', '0');

            String[] statusDescriptions = {
                    "Признак перезагрузки терминала",
                    "Номер SIM карты по которой подключен терминал (0-SIM0,1-SIM1)",
                    "Отсутствует соединение с сервером",
                    "Охраный режим",
                    "Признак низкого напряжения на аккумуляторе",
                    "Признак недействительности координат (валидность)",
                    "Координаты зафиксированы при отсутствии движения",
                    "Отключено внешнее питание терминала",
                    "Сработка охранной сигнализации",
                    "Обрыв GPS/Глонасс антенны",
                    "Короткое замыкание GPS/Глонасс антенны",
                    "Высокое напряжение питания",
                    "В качестве черного ящика используется SD карта",
                    "Обнаружено вскрытие корпуса",
                    "Координаты определенны при помощи базовых станций GSM",
                    "Нажата кнопка тангенты"
            };

            for (int i = 0; i < statusDescriptions.length; i++) {
                if (binaryString.charAt(i) == '1') {
                    statusText.append(statusDescriptions[i]).append(";\n ");
                }
            }
        } else {
            statusText.append("отсутствие данных о устройстве;\n ");
        }

        return statusText.toString().trim();
    }

    // Вычисляет среднюю скорость устройства за указанный период
    public String calculateAverageSpeed(String objName, LocalDate startDate, LocalDate endDate) {
        List<ObjParams> objParamsList = objParamsRepository.findByObjName(objName);
        double totalSpeed = 0.0;
        int count = 0;

        for (ObjParams objParam : objParamsList) {
            LocalDateTime startDateTime = startDate.atStartOfDay();
            LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);

            List<Params> paramsList = paramsRepository.findBySpeedTimeBetween(startDateTime, endDateTime);
            if (!paramsList.isEmpty()) {
                totalSpeed += paramsList.stream()
                        .filter(params -> params.getSpeed() != null && !params.getSpeed().isEmpty())
                        .mapToDouble(params -> Double.parseDouble(params.getSpeed()))
                        .sum();
                count += paramsList.size();
            }
        }

        double result = count > 0 ? totalSpeed / count : 0.0;

        String resultText =("Значение средней скорости  устройства: "+ objName+ "\n за период с " + startDate+" по "+endDate+" равняется "+result);
        return resultText;
    }
}