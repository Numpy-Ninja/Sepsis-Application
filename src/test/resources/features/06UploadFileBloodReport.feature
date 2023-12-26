@UploadBloodReport
Feature: Validitate Blood Profile upload files

  @TS_01ValidateRiskOfSepsis
  Scenario Outline: Validitate Risk Of Sepsis
    Given Patient is on details tab in saved patient form
    Then the status of RiskOfSepsis should be shown "<SepsisStatus>"

    Examples: 
      | SepsisStatus |
      | LOW      |

  @TS_02ValiditateBloodProfileuploadfiles
  Scenario: Validitate Blood Profile upload files
    Given Patient is on related tab in saved patient form
    When Patient clicks on the upload file option
    Then Patient should able to upload a file with a successful message "1 file was uploaded."