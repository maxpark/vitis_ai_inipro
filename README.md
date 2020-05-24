# vitis_ai

## Download
 - <a href="https://www.xilinx.com/member/forms/download/xef.html?filename=sstate_aarch64_2019.2.tar.gz">sstate_aarch64_2019.2.tar.gz</a>
 - <a href="https://inipro-my.sharepoint.com/:u:/g/personal/admin_inipro_onmicrosoft_com/ET4jm31q0KNMofiI4aXsrOkB-huEFgoqQ37UKQGxS3pRrQ?e=AYBl3J">sstate_aarch64_2019.2_2.tar.gz</a>
 - <a href="https://www.xilinx.com/member/forms/download/xef.html?filename=downloads_2019.2.tar.gz">downloads.tar.gz</a>
 - <a href="https://inipro-my.sharepoint.com/:u:/g/personal/admin_inipro_onmicrosoft_com/ES79k1GAUJZGiLIs-ouX7VkBUI4gAv1c-uZ6xjUtmrf_Tg?e=mztIer">sdk.zip</a>

- <a href="https://www.xilinx.com/products/boards-and-kits/alveo/u200.html#gettingStarted">[Xilinx Runtime]</a>


## Exercise

<a href="http://avnet.me/vitis_ai_model_ULTRA96V2_2019.2-r1.1.1.deb">[vitis_ai_model for Ultra96v2]</a>  
<a href="https://github.com/Xilinx/AI-Model-Zoo/tree/7f3456b26724cc649960e3b6924488859eebe489">[Vitis AI Model Zoo]</a>

<a href="https://www.xilinx.com/support/documentation/sw_manuals/vitis_ai/1_1/ug1414-vitis-ai.pdf">[ug1414 vitis ai]</a>  
<a href="https://www.xilinx.com/support/documentation/ip_documentation/dpu/v3_2/pg338-dpu.pdf">[pg338 dpu]</a>  

<a href="https://github.com/gewuek/vitis_ai_custom_platform_flow">[vitis ai custom platform flow]</a>


#### Generate Bitstream
```
$ cd ~/work/
$ git clone https://github.com/inipro/vitis_ai.git
$ cd vitis_ai
$ vivado -nolog -nojournal -mode batch -source ultra96v2_base.tcl
$ cd ultra96v2_base
$  vivado ultra96v2_base.xpr
Generate Bitstream
```

#### Generate XSA
```
Tcl Console
cd ..
source ultra96v2_base_xsa.tcl
```

#### Vitis Flow
```
$ cd petalinux  

BUILD.txt 의 Vitis Flow 을 수행

$ cd ~/work/vitis_ai
$ mkdir src/a53/xrt/image
$ mkdir src/boot
$ ./copy.sh
$ xsct -sdx ultra96v2_base_pfm.tcl
$ mkdir platforms
$ mv output/ultra96v2_base/export/ultra96v2_base platforms
$ cd dpu_prj
$ source /opt/Xilinx/Vitis/2019.2/settings64.sh
$ make KERNEL=DPU DEVICE=ultra96 SDX_PLATFORM=../platforms/ultra96v2_base/ultra96v2_base.xpfm
```
