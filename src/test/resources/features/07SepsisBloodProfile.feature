@SepsisBloodProfile
Feature: Validitate Sepsis BloodProfile

 

  @TS_02ValiditateSepsisBloodProfileNewForm
  Scenario Outline: Validitate Sepsis BloodProfile New Form
    Given Admin is on Sepsis Blood Profile Object
    When Admin Clicks on New Form
    And Admin enters the "<PatientId>","<PaO2>","<Systolicblo>","<Diastlicblo>","<Hr>" ,"<Egfr>","<Troponin>", "<PacO2>", "<FiO2>"
    Then Admin clicks on the save button the form should be saved

    Examples: 
      | PatientId | PaO2 | Systolicblo | Diastlicblo | Hr  | Egfr | Troponin | PacO2 | FiO2 |
      | PT-0498   |   89 |         130 |         120 | 120 |   56 |     0.02 |     0 | 0.37 |

  @TS_03ValiditateSepsisBloodProfileSavedForm
  Scenario Outline: Validitate Sepsis BloodProfile Saved Form
    Given Admin is on Sepsis Blood Profile Object
    When Admin opens the saved Form
    Then Admin should be able to see the values for "<P/F Ratio>","<Cardiac Output>","<Myocardial Depression>","<eGFR output>" ,"<fio2>", "<P/F Output Result>"

    Examples: 
      | P/F Ratio | Cardiac Output | Myocardial Depression | eGFR output    | fio2 | P/F Output Result            |
      |        89 |           4.80 | Abnormal              | Kidney Disease |   37 | Critical Respiratory Failure |

  @TS_04ValiditateOrganFailureInPatientSavedForm
  Scenario Outline: Validitate Organ Failure in Patient Saved Form
    Given Admin is on Patient Object
    When Admin opens the saved Patient Form
    Then Admin should be able to check the status of the Kidney failure, Heart failure , Respiratory failure
