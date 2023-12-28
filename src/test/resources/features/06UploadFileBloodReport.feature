@UploadBloodReport
Feature: Validitate Blood Profile upload files

  @TS_01ValiditateBloodProfileuploadfiles
  Scenario: Validitate Blood Profile upload files
    Given Patient is on related tab in saved patient form
    When Patient clicks on the upload file option
    Then Patient should able to upload a file with a successful message "1 file was uploaded."